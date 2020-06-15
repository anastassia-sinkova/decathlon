function getTotalScore() {
    var formArray = $('#scores').serializeArray();

    var formAsJson = [];

    for (var i = 0; i < formArray.length; i++) {
        var element = {};

        if (!formArray[i]['value']) {
            continue;
        }

        element['event'] = formArray[i]['name'];
        element['score'] = formArray[i]['value'];

        formAsJson[i] = element;
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
