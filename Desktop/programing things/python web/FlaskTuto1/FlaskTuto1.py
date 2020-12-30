from flask import Flask, redirect, url_for, render_template


a=True

app=Flask(__name__)

@app.route("/")
def home():
	return "Hello, <h1>this is the main page</h1>"

@app.route("/<name>")
def user(name):
	return f"Hello {name}!"


@app.route("/admin")
def admin():
	if a :
		return redirect(url_for("user", name="Admin!"))
	else:
		return redirect(url_for("home"))
		

if __name__ == "__main__":
	app.run()

