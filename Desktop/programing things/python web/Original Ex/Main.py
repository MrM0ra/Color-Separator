from Person import Person
from flask import Flask, redirect, url_for, render_template, request

class Main:

	person1=""

	app=Flask(__name__)

	@app.route("/")
	def home():
		return render_template("index.html")

	@app.route("/login", methods=["POST", "GET"])
	def login():
		if request.method == "POST":
			name = request.form["nm"]
			email = request.form["email"]
			pwd = request.form["pwd"]
			age = request.form["age"]
			person1=Person(name, email, pwd, age)
			introduction=person1.introduce2()
			print(introduction)
			return redirect(url_for("user", usr=name))
		else:
			return render_template("login.html")

	@app.route("/<usr>")
	def user(usr):
		return f"<h1>Hello {usr}</h1>"

	if __name__ == "__main__":
		app.run(debug=True)