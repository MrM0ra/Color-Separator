import os

from flask import Flask, redirect, url_for, render_template

from flask_socketio import SocketIO, send, emit, join_room, leave_room

a=True

app=Flask(__name__)
app.secret_key=os.environ.get('SecretKey')

#Initialize SocetIO
socketio=SocketIO(app)

ROOMS=["lounge", "news", "games", "coding"]
COLORS=["Black", "Blue", "Cian", "Gray", "Green", "Pink", "Purple", "Red", "Yellow"]
USERS=[]

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
		

@app.route("/chat")
def chat():
	return render_template('chat.html', rooms=ROOMS)

#Event Bucket
@socketio.on('message')
def message(data):
	msg = data["msg"]
	username=data["username"]
	room=data["room"]
	send({"username": username, "msg": msg}, room=room)
    
@socketio.on('join')
def join(data):
	username=data['username']
	room=data['room']
	message=username+' has join the ' + room + " room."
	join_room(room)
	send({'username': username, 'msg': message}, room=room)

@socketio.on('leave')
def leave(data):
	username=data['username']
	room=data['room']
	message=username+' has left the ' + room + " room."
	leave_room(room)
	send({'username': username, 'msg': message}, room=room)

if __name__ == "__main__":
	app.run()
