const newTaskInput = document.getElementById("new_task")
const todoList = document.getElementById("todo_list")
const button = document.getElementById("button")
// 


window.addEventListener("load", init);


const init = () => {
    aggiungiTask(); 
    task(); 
    taskCompletata(); 

}


const aggiungiTask = () => {
    let li = document.createElement("li");
    li.innerHTML =
        `<div class="task">
        <span id="task_name">
             ${newTaskInput.value}
        </span>
             <button class="delete">
                <span class="material-symbols-outlined">
                 remove
                </span>
            </button>
     </div>
         `;

    todoList.appendChild(li);
    newTaskInput.value = "";

}

const task = () => {
    let task = document.querySelector("task")
    for (let i = 0; i < task.length; i++) {
        task[i].addEventListener("click", function () {
            this.parentNode.toggle("completed")
        })
    }
}



const taskCompletata = () => {
    let button = document.querySelector("delete");
    for (let i = 0; i < button.length; i++) {
        button[i].addEventListener("click", function () {
            this.parentNode.remove()
        })
    }
} 





