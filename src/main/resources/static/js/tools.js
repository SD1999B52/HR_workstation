/*--------------------
сортировка и пагинация
--------------------*/

//пагинация и сортировка
function openPage(page) {
    document.location = '?page=' + page + '&sort=' + column + ',' + direction;
}

//следующая страница
function nextPage() {
    openPage(parseInt(page) + 1);
}

//предыдущая страница
function previousPage() {
    if (parseInt(page) > 0) {
        openPage(parseInt(page) - 1);
    }
}

//задать столбец для сортировки
function setColumn(column) {
    window.column = column;
    openPage(page);
}

//задать сортировку по возростанию
function ascSort() {
    direction = 'ASC';
    openPage(page);
}

//задать сортировку по убыванию
function descSort() {
    direction = 'DESC';
    openPage(page);
}