const socket = new WebSocket("ws://127.0.0.1:7070/time");

const timeEl = document.getElementById("time")
socket.onmessage = function ({data}) {
    timeEl.textContent = data
}