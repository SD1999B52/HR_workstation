//поля строки для редактирования
const id = document.getElementById('id');
const employee = document.getElementById('employee');
const username = document.getElementById('username');
const password = document.getElementById('password');
const enabled = document.getElementById('enabled');
const authority = document.getElementById('authority');

//выбрать значение select по тексту
function selectedByText(select, text) {
    var options = select.options;
    
    for (var i = 0; i < options.length; i++) {
        if (options[i].text == text) {
            options[i].selected = true;
            
            break;
        }
    }
}

//функция кнопки изменения данных
function update(button) {
    //ячейки ближайшей строки к нажатой кнопке
    var cells = button.closest('tr').cells;
    
    id.value = cells[0].innerText;
    
    selectedByText(employee, cells[1].innerText);
    
    username.value = cells[2].innerText;
    password.value = cells[3].innerText;
    
    selectedByText(enabled, cells[4].innerText);
    selectedByText(authority, cells[5].innerText);
}