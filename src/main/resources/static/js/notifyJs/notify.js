function notifySuccess(message) {
    $.notify({
        message: message
    },{
        type: 'success'
    })
}

function notifyFailure(message) {
    $.notify({
        message: message
    },{
        type: 'danger'
    })
}