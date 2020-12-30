document.addEventListener('DOMContentLoaded', () => {
	var socket = io.connect('http://'+document.domain+':'+location.port);
	
	let room = "Lounge"
    joinRoom("Lounge");

	//Display incoming message
	socket.on('message', data => {
		const p = document.createElement('p');
		const span_username=document.createElement('span');
		const br = document.createElement('br');
		span_username.innerHTML=data.username;
		p.innerHTML = data.username + ": "+data.msg + br.outerHTML;
		document.querySelector('#display-message-section').append(p);
	});

	//Send message
	document.querySelector('#send_message').onclick = () => {
		socket.send({'msg': document.querySelector('#user_message').value,
		'username':document.querySelector('#username').value, 'room':room});
		document.querySelector('#user_message').value = '';
	}

	//Room selection
	document.querySelectorAll('.select-room').forEach(p => {
		p.onclick = () => {
			let newRoom = p.innerHTML;
			if(newRoom == room){
				msg = `You are already in the ${room} room.`
				printSysMsg(msg);
			}else{
				leaveRoom(room);
				joinRoom(newRoom);
				room=newRoom;
			}
		}
	})

	//Leave room
	function leaveRoom(room){
		socket.emit('leave', {'username': document.querySelector('#username').value, 'room': room});
	}

	//Join room
	function joinRoom(room){
		socket.emit('join', {'username': document.querySelector('#username').value, 'room': room});
		document.querySelector('#display-message-section').innerHTML = '';
		//Autofocus the textbox
		document.querySelector('#user_message').focus();

	}

	//Print system message
	function printSysMsg(msg){
		const p = document.createElement('p');
		p.innerHTML = msg;
		console.log(msg);
		document.querySelector('#display-message-section').append(p);
	}
})

