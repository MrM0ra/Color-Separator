from flask import Flask, redirect, url_for, render_template, request

class Main:

	app=Flask(__name__)

	@app.route("/")
	def home():
		return render_template("home.html")

	@app.route("/login/")
	def login():
		return render_template("login.html")

	@app.route("/signup/")
	def signup():
		return render_template("signUp.html")

	if __name__ == "__main__":
		app.run(debug=True)