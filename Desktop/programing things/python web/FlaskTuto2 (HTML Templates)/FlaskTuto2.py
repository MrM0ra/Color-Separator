from flask import Flask, redirect, url_for, render_template


a=True

app=Flask(__name__)

@app.route("/")
def home():
	return render_template("index.html", content=["Bill", "Joe", "Tim", "Jax"])

'''
@app.route("/<name>")
def user(name):
	return f"Hello {name}!"

@app.route("/admin")
def admin():
		return redirect(url_for("home"))
'''

if __name__ == "__main__":
	app.run(debug=True)

