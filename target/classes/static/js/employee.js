/*---------------------------------------------------
таблицы
---------------------------------------------------*/

//функция удаления строки в таблице encouragementTable
function deleteRowEncouragementTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('encouragementTable');
}

//функция добавления строки таблице encouragementTable
function addRowEncouragementTable() {
    var toeTextarea = document.createElement('textarea');
    toeTextarea.setAttribute('name', 'encouragement[].toe');
    
    var basesTextarea = document.createElement('textarea');
    basesTextarea.setAttribute('name', 'encouragement[].bases');
    
    var documentInput = document.createElement('input');
    documentInput.setAttribute('type', 'text');
    documentInput.setAttribute('name', 'encouragement[].document');
    
    var doeInput = document.createElement('input');
    doeInput.setAttribute('type', 'date');
    doeInput.setAttribute('name', 'encouragement[].doe');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowEncouragementTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('encouragementTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var toeTextareaCell = row.insertCell(1);
    toeTextareaCell.appendChild(toeTextarea);
    
    var basesTextareaCell = row.insertCell(2);
    basesTextareaCell.appendChild(basesTextarea);
    
    var documentInputCell = row.insertCell(3);
    documentInputCell.appendChild(documentInput);
    
    var doeInputCell = row.insertCell(4);
    doeInputCell.appendChild(doeInput);
    
    var deleteButtonCell = row.insertCell(5);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('encouragementTable');
}

//функция удаления строки в таблице vacationTable
function deleteRowVacationTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('vacationTable');
}

//функция добавления строки таблице vacationTable
function addRowVacationTable() {
    var tovSelect = document.createElement('select');
    tovSelect.setAttribute('name', 'vacation[].tov');
    
    //добавляем опции
    var basicOption = document.createElement('option');
    basicOption.setAttribute('value', 'basic');
    basicOption.setAttribute('label', 'Ежегодный основной оплачиваемый отпуск');
    tovSelect.appendChild(basicOption);
    
    var additionalOption = document.createElement('option');
    additionalOption.setAttribute('value', 'additional');
    additionalOption.setAttribute('label', 'Ежегодный дополнительный отпуск');
    tovSelect.appendChild(additionalOption);
    
    var studyOption = document.createElement('option');
    studyOption.setAttribute('value', 'study');
    studyOption.setAttribute('label', 'Учебный отпуск');
    tovSelect.appendChild(studyOption);
    
    var unpaidOption = document.createElement('option');
    unpaidOption.setAttribute('value', 'unpaid');
    unpaidOption.setAttribute('label', 'Отпуск без сохранения заработной платы');
    tovSelect.appendChild(unpaidOption);
    
    var maternityOption = document.createElement('option');
    maternityOption.setAttribute('value', 'maternity');
    maternityOption.setAttribute('label', 'Отпуск по уходу за ребенком и отпуск по беременности и родам');
    tovSelect.appendChild(maternityOption);
    //конец
    
    var basesTextarea = document.createElement('textarea');
    basesTextarea.setAttribute('name', 'vacation[].bases');
    
    var dosvInput = document.createElement('input');
    dosvInput.setAttribute('type', 'date');
    dosvInput.setAttribute('name', 'vacation[].dosv');
    
    var doevInput = document.createElement('input');
    doevInput.setAttribute('type', 'date');
    doevInput.setAttribute('name', 'vacation[].doev');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowVacationTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('vacationTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var tovSelectCell = row.insertCell(1);
    tovSelectCell.appendChild(tovSelect);
    
    var basesTextareaCell = row.insertCell(2);
    basesTextareaCell.appendChild(basesTextarea);
    
    var dosvInputCell = row.insertCell(3);
    dosvInputCell.appendChild(dosvInput);
    
    var doevInputCell = row.insertCell(4);
    doevInputCell.appendChild(doevInput);
    
    var deleteButtonCell = row.insertCell(5);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('vacationTable');
}

//функция удаления строки в таблице benefitTable
function deleteRowBenefitTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('benefitTable');
}

//функция добавления строки таблице benefitTable
function addRowBenefitTable() {
    var nameTextarea = document.createElement('textarea');
    nameTextarea.setAttribute('name', 'benefit[].name');
    
    var documentInput = document.createElement('input');
    documentInput.setAttribute('type', 'text');
    documentInput.setAttribute('name', 'benefit[].document');
    
    var dosbInput = document.createElement('input');
    dosbInput.setAttribute('type', 'date');
    dosbInput.setAttribute('name', 'benefit[].dosb');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowBenefitTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('benefitTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var nameTextareaCell = row.insertCell(1);
    nameTextareaCell.appendChild(nameTextarea);
    
    var documentInputCell = row.insertCell(2);
    documentInputCell.appendChild(documentInput);
    
    var dosbInputCell = row.insertCell(3);
    dosbInputCell.appendChild(dosbInput);
    
    var deleteButtonCell = row.insertCell(4);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('benefitTable');
}

//функция удаления строки в таблице trainingTable
function deleteRowTrainingTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('trainingTable');
}

//функция добавления строки таблице trainingTable
function addRowTrainingTable() {
    var informationTextarea = document.createElement('textarea');
    informationTextarea.setAttribute('name', 'training[].information');
    
    var dosatInput = document.createElement('input');
    dosatInput.setAttribute('type', 'date');
    dosatInput.setAttribute('name', 'training[].dosat');
    
    var doeatInput = document.createElement('input');
    doeatInput.setAttribute('type', 'date');
    doeatInput.setAttribute('name', 'training[].doeat');
    
    var institutionTextarea = document.createElement('textarea');
    institutionTextarea.setAttribute('name', 'training[].institution');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowTrainingTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('trainingTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var informationTextareaCell = row.insertCell(1);
    informationTextareaCell.appendChild(informationTextarea);
    
    var dosatInputCell = row.insertCell(2);
    dosatInputCell.appendChild(dosatInput);
    
    var doeatInputCell = row.insertCell(3);
    doeatInputCell.appendChild(doeatInput);
    
    var institutionTextareaCell = row.insertCell(4);
    institutionTextareaCell.appendChild(institutionTextarea);
    
    var deleteButtonCell = row.insertCell(5);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('trainingTable');
}

//функция удаления строки в таблице assignmentTable
function deleteRowAssignmentTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('assignmentTable');
}

//функция добавления строки таблице assignmentTable
function addRowAssignmentTable() {
    var placeTextarea = document.createElement('textarea');
    placeTextarea.setAttribute('name', 'assignment[].place');
    
    var numberInput = document.createElement('input');
    numberInput.setAttribute('type', 'text');
    numberInput.setAttribute('name', 'assignment[].number');
    
    var informationTextarea = document.createElement('textarea');
    informationTextarea.setAttribute('name', 'assignment[].information');
    
    var dosbtInput = document.createElement('input');
    dosbtInput.setAttribute('type', 'date');
    dosbtInput.setAttribute('name', 'assignment[].dosbt');
    
    var doebtInput = document.createElement('input');
    doebtInput.setAttribute('type', 'date');
    doebtInput.setAttribute('name', 'assignment[].doebt');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowAssignmentTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('assignmentTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var placeTextareaCell = row.insertCell(1);
    placeTextareaCell.appendChild(placeTextarea);
    
    var numberInputCell = row.insertCell(2);
    numberInputCell.appendChild(numberInput);
    
    var informationTextareaCell = row.insertCell(3);
    informationTextareaCell.appendChild(informationTextarea);
    
    var dosbtInputCell = row.insertCell(4);
    dosbtInputCell.appendChild(dosbtInput);
    
    var doebtInputCell = row.insertCell(5);
    doebtInputCell.appendChild(doebtInput);
    
    var deleteButtonCell = row.insertCell(6);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('assignmentTable');
}

//функция удаления строки в таблице sickTable
function deleteRowSickTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('sickTable');
}

//функция добавления строки таблице sickTable
function addRowSickTable() {
    var certificateInput = document.createElement('input');
    certificateInput.setAttribute('type', 'text');
    certificateInput.setAttribute('name', 'sick[].certificate');
    
    var dosslInput = document.createElement('input');
    dosslInput.setAttribute('type', 'date');
    dosslInput.setAttribute('name', 'sick[].dossl');
    
    var doeslInput = document.createElement('input');
    doeslInput.setAttribute('type', 'date');
    doeslInput.setAttribute('name', 'sick[].doesl');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowSickTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('sickTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var certificateInputCell = row.insertCell(1);
    certificateInputCell.appendChild(certificateInput);
    
    var dosslInputCell = row.insertCell(2);
    dosslInputCell.appendChild(dosslInput);
    
    var doeslInputCell = row.insertCell(3);
    doeslInputCell.appendChild(doeslInput);
    
    var deleteButtonCell = row.insertCell(4);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('sickTable');
}

//функция удаления строки в таблице physicalTable
function deleteRowPhysicalTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('physicalTable');
}

//функция добавления строки таблице physicalTable
function addRowPhysicalTable() {
    var domeInput = document.createElement('input');
    domeInput.setAttribute('type', 'date');
    domeInput.setAttribute('name', 'physical[].dome');
    
    var institutionTextarea = document.createElement('textarea');
    institutionTextarea.setAttribute('name', 'physical[].institution');
    
    var conclusionTextarea = document.createElement('textarea');
    conclusionTextarea.setAttribute('name', 'physical[].conclusion');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowPhysicalTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('physicalTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var domeInputCell = row.insertCell(1);
    domeInputCell.appendChild(domeInput);
    
    var institutionTextareaCell = row.insertCell(2);
    institutionTextareaCell.appendChild(institutionTextarea);
    
    var conclusionTextareaCell = row.insertCell(3);
    conclusionTextareaCell.appendChild(conclusionTextarea);
    
    var deleteButtonCell = row.insertCell(4);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('physicalTable');
}

//функция удаления строки в таблице positionTable
function deleteRowPositionTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('positionTable');
}

//функция добавления строки таблице positionTable
function addRowPositionTable() {
    var deptSelect = document.createElement('select');
    deptSelect.setAttribute('name', 'position[].dept');
    
    //добавляем опции
    for (var i = 0; i < departments.length; i++) {
        var option = document.createElement('option');
        
        option.setAttribute('value', departments[i].id);
        option.setAttribute('label', departments[i].name);
        
        deptSelect.appendChild(option);
    }
    
    var nameInput = document.createElement('input');
    nameInput.setAttribute('type', 'text');
    nameInput.setAttribute('name', 'position[].name');
    
    var salaryInput = document.createElement('input');
    salaryInput.setAttribute('type', 'number');
    salaryInput.setAttribute('name', 'position[].salary');
    
    var doeInput = document.createElement('input');
    doeInput.setAttribute('type', 'date');
    doeInput.setAttribute('name', 'position[].doe');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowPositionTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('positionTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var deptSelectCell = row.insertCell(1);
    deptSelectCell.appendChild(deptSelect);
    
    var nameInputCell = row.insertCell(2);
    nameInputCell.appendChild(nameInput);
    
    var salaryInputCell = row.insertCell(3);
    salaryInputCell.appendChild(salaryInput);
    
    var doeInputCell = row.insertCell(4);
    doeInputCell.appendChild(doeInput);
    
    var deleteButtonCell = row.insertCell(5);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('positionTable');
}

//функция удаления строки в таблице dismissalTable
function deleteRowDismissalTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('dismissalTable');
}

//функция добавления строки таблице dismissalTable
function addRowDismissalTable() {
    var dodInput = document.createElement('input');
    dodInput.setAttribute('type', 'date');
    dodInput.setAttribute('name', 'dismissal[].dod');
    
    var notesTextarea = document.createElement('textarea');
    notesTextarea.setAttribute('name', 'dismissal[].notes');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowDismissalTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('dismissalTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var dodInputCell = row.insertCell(1);
    dodInputCell.appendChild(dodInput);
    
    var notesTextareaCell = row.insertCell(2);
    notesTextareaCell.appendChild(notesTextarea);
    
    var deleteButtonCell = row.insertCell(3);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('dismissalTable');
}

//функция удаления строки в таблице hiringTable
function deleteRowHiringTable(event) {
    event.target.closest('tr').remove();
    overrideFieldNames('hiringTable');
}

//функция добавления строки таблице hiringTable
function addRowHiringTable() {
    var dohInput = document.createElement('input');
    dohInput.setAttribute('type', 'date');
    dohInput.setAttribute('name', 'hiring[].doh');
    
    var notesTextarea = document.createElement('textarea');
    notesTextarea.setAttribute('name', 'hiring[].notes');
    
    var deleteButton = document.createElement('button');
    deleteButton.setAttribute('type', 'button');
    deleteButton.setAttribute('onclick', 'deleteRowHiringTable(event)');
    deleteButton.textContent = 'Удалить';
    
    var table = document.getElementById('hiringTable');
    var row = table.insertRow(1);
    
    row.insertCell(0);
    
    var dohInputCell = row.insertCell(1);
    dohInputCell.appendChild(dohInput);
    
    var notesTextareaCell = row.insertCell(2);
    notesTextareaCell.appendChild(notesTextarea);
    
    var deleteButtonCell = row.insertCell(3);
    deleteButtonCell.appendChild(deleteButton);
    
    overrideFieldNames('hiringTable');
}

//переопределить имена полей в таблице
function overrideFieldNames(tableId) {
    var table = document.getElementById(tableId);
    
    for (var i = 1; i < table.rows.length; i++) {
        var row = table.rows[i];
        var number = row.cells[0];
        
        number.textContent = i - 1;
        
        for (var j = 1; j < row.cells.length; j++) {
            var object = row.cells[j].firstElementChild;
            
            var a = object.name.slice(0, object.name.indexOf('[') + 1);
            var b = object.name.slice(object.name.indexOf(']'));
            
            object.name = a + (i - 1) + b;
        }
    }
}

/*---------------------------------------------------
вкладки
---------------------------------------------------*/

//функция открытия вкладки
function openTab(buttonId, tabId) {
    var tabcontent = document.getElementsByClassName('TabContent');
    for (var i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = 'none';
    }
    
    var tablinks = document.getElementsByClassName('TabLinks');
    for (var i = 0; i < tablinks.length; i++) {
        tablinks[i].style.borderBottom = '2px solid black';
    }
    
    document.getElementById(tabId).style.display = 'block';
    document.getElementById(buttonId).style.borderBottom = 'none';
}

/*---------------------------------------------------
события
---------------------------------------------------*/

var tab1Button = document.getElementById('tab1Button');
tab1Button.addEventListener('click', function () {
    openTab(this.id, 'tab1');
});

var tab2Button = document.getElementById('tab2Button');
tab2Button.addEventListener('click', function () {
    openTab(this.id, 'tab2');
});

var tab3Button = document.getElementById('tab3Button');
tab3Button.addEventListener('click', function () {
    openTab(this.id, 'tab3');
});

var tab4Button = document.getElementById('tab4Button');
tab4Button.addEventListener('click', function () {
    openTab(this.id, 'tab4');
});

var tab5Button = document.getElementById('tab5Button');
tab5Button.addEventListener('click', function () {
    openTab(this.id, 'tab5');
});

tab1Button.click();