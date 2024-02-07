const newTaskInput = document.getElementById("new_task")
const todoList = document.getElementById("todo_list")
const button = document.getElementById("button")
// 
let array =[];


window.addEventListener('load', init);


/*
prima prova : 
 function aggiungiTask() {
    let li = document.createElement("li");
    li.innerHTML = todoList.value;
    todoList.appendChild(newTaskInput);
    } */ 
function aggiungiTask() {
    let li = document.createElement("li");
    li.textContent = newTaskInput.value;
    todoList.appendChild(li);
    newTaskInput.value = "";

} 
