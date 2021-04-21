package application;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SampleController {

	private String appPath;
	
	private BufferedImage f;
	
	@FXML
    private Pane imagePane;
	
	@FXML
    private Button btnSeparate;

    @FXML
    private Button btnSelectImage;
	
    @FXML
    private ImageView selectedImage;

    @FXML
    private ListView<TextField> selectedColors;
    
    private ArrayList<Color> colors;
    
    private String imgName;
    
    private java.net.URL imgUrl;
    
    private int r,g,b;
	private Color col;
    
    public SampleController() {
    	colors=new ArrayList();
    }
    
    public void initialize() {
    	
    	selectPicture();
    	
    	btnSelectImage.setOnMouseClicked(e->{
    		selectPicture();
    		selectedColors.getItems().removeAll(selectedColors.getItems());
    		colors.removeAll(colors);
    		
    	});
    	
    	btnSeparate.setOnMouseClicked(e->{
    		int index=1;
    		appPath=this.getClass().getClassLoader().getResource("").getPath();
    		appPath=appPath.split("/bin")[0];
        	appPath=appPath+"/src/colors/";
    		File file = new File(appPath+imgName);
    		System.out.println("OnClicked: "+appPath+imgName);
			boolean bool = file.mkdirs();
		      if(bool){
		         System.out.println("Directory created successfully");
		      }else{
		         System.out.println("Sorry couldn’t create specified directory");
		      }
    		for (Color c: colors) {
    			try {
    				separateColor(c, index);
					index++;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
    	});
    	
    	selectedImage.setOnMouseClicked(e->{
	         Color color=new Color(f.getRGB((int) (e.getX()), (int) (e.getY())));
	         
	         colors.add(color);
	         
	         TextField tf = new TextField();
	         tf.setPrefWidth(5);
	         tf.setPrefHeight(5);
	         tf.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue()), null, null)));
	         selectedColors.getItems().add(tf);	         
	         e.consume();
    	});
    	
    }
    
	public void separateColor(Color color, int index) throws IOException{
		BufferedImage focus=ImageIO.read(imgUrl);
		for(int i=0;i<focus.getWidth();i++){
			for(int j=0;j<focus.getHeight();j++){
				col = new Color(focus.getRGB(i, j));
				r = col.getRed();
				g = col.getGreen();
				b = col.getBlue();
				if(Math.abs(color.getRed()-r)<=15  && Math.abs(color.getGreen()-g)<=15 && Math.abs(color.getBlue()-b)<=15) {
					focus.setRGB(i, j, new Color(0,0,0).getRGB());	
				}else {
					focus.setRGB(i, j, new Color(255,255,255).getRGB());
				}
			}
		}
		String imgPath=appPath+imgName+"/"+imgName+index+".png";
		System.out.println("Before saving: "+imgPath);
		savePNG(focus, imgPath);
	}
    
	private static void savePNG(final BufferedImage bi, final String path){
		try {
	            RenderedImage rendImage = bi;
	            System.out.println("OnSaving: "+path);
	            ImageIO.write(rendImage, "PNG", new File(path));
	        } catch ( IOException e) {
	            e.printStackTrace();
	        }
	    }
	
    public void selectPicture() { 
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Picture Selection");
		alert.setHeaderText(null);
		ButtonType buttonTypeOne = new ButtonType("Find Picture");
		alert.getButtonTypes().setAll(buttonTypeOne);
		alert.setContentText("Select a picture!");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
			FileChooser fileChooser = new FileChooser(); 
			File file = fileChooser.showOpenDialog(new Stage());
			try {
				java.net.URL url = file.toURI().toURL();
				imgUrl=file.toURI().toURL();
				String[] heehee=url.toExternalForm().split("/");
				String name=heehee[heehee.length-1];;
				imgName=name.substring(0, name.length()-4);
				Image img=new Image(url.toExternalForm());
				f=ImageIO.read(url);
				
				imagePane.setPrefWidth(img.getWidth());
				imagePane.setPrefHeight(img.getHeight());
				
				getSelectedImage().setFitWidth(img.getWidth());
				getSelectedImage().setFitHeight(img.getHeight());
				
				getSelectedImage().setImage(img);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
    
    public ImageView getSelectedImage() {
    	return selectedImage;
    }

}

