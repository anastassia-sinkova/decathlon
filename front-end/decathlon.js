function getTotalScore() {
    var formArray = $('#scores').serializeArray();

    var formAsJson = {};

    for (var i = 0; i < formArray.length; i++){
        formAsJson[formArray[i]['name']] = formArray[i]['value'];
    }

    $.ajax({
        url: 'http://localhost:8080/total-score',
        type: 'POST',
        data: JSON.stringify(formAsJson),
        contentType: 'application/json',
        dataType: 'json',
        success: function(totalScore) {
            $('#totalScore').html('Total score: ' + totalScore);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            $('#totalScore').html('Error occurred!');
        }
    })
}
