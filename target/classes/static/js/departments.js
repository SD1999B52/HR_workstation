//поля строки для редактирования
const id = document.getElementById('id');
const name = document.getElementById('name');
const number = document.getElementById('number');

//функция кнопки изменения данных
function update(button) {
    //ячейки ближайшей строки к нажатой кнопке
    var cells = button.closest('tr').cells;
    
    id.value = cells[0].innerText;
    name.value = cells[1].innerText;
    number.value = cells[2].innerText;
}