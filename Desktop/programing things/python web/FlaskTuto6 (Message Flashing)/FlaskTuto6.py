'''
HTTP Methods
How to get info from a form
'''

from flask import Flask, redirect, url_for, render_template, request, session, flash
from datetime import timedelta

app=Flask(__name__)

app.secret_key = "morde"

#Sesion "permanente"
#app.permanent_session_lifetime = timedelta(days=30)
app.permanent_session_lifetime = timedelta(minutes=5)

@app.route("/")
def home():
	return render_template("index.html")

@app.route("/login", methods=["POST", "GET"])
def login():
	if request.method == "POST":
		#Sesion "permanente" Dura lo que definimos en la linea 14
		session.permanent = True
		user = request.form["nm"]
		session["user"]=user
		flash("Login succesful!")
		return redirect(url_for("user"))
	else:
		if "user" in session:
			flash("Already logged in!")
			return redirect(url_for("user"))

		return render_template("login.html")

@app.route("/logout")
def logout():
	flash("You have been logged out!", "info")
	session.pop("user", None)
	return redirect(url_for("login"))

@app.route("/user")
def user():
	if "user" in session:
		user=session["user"]
		return render_template("user.html", user=user)
	else:
		flash("You are not logged in!")
		return redirect(url_for("login"))

if __name__ == "__main__":
	app.run(debug=True)

