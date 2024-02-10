//кнопка создать запись
function insert() {
    document.location = 'employee';
}

//кнопка открыть карточку сотрудника
function update(id) {
    document.location = 'employee?id=' + id;
}