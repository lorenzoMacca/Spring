var AjaxSetUp = {

    sendRequestAndHandleAnswer: function CallMethod(
        url,
        method,
        requestObject,
        dataForCb,
        successCallback=this.defaultSuccessCallback,
        errCallback=this.defaultFailureCallback)
    {
        $.ajax({
            type: method,
            url: url,
            data: JSON.stringify(requestObject),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
        }).done(function (data, textStatus, xhr) {
            successCallback(dataForCb, data, textStatus, xhr);
        }).fail(function (data, textStatus, xhr) {
            errCallback(data, textStatus, xhr);
        });
    },

    sendGetRequest: function (
        url,
        callbackData,
        successCallback=this.defaultSuccessCallback,
        errCallback=this.defaultFailureCallback
    ){
        this.sendRequestAndHandleAnswer(
            url,
            'GET',
            undefined,
            callbackData,
            successCallback,
            errCallback
        )
    },

    sendPutRequest: function (
        url,
        callbackData,
        successCallback=this.defaultSuccessCallback,
        errCallback=this.defaultFailureCallback
    ){
        this.sendRequestAndHandleAnswer(
            url,
            'PUT',
            undefined,
            callbackData,
            successCallback,
            errCallback
        )
    },

    defaultSuccessCallback: function successCallback(callbackData, data) {
        console.log("Sucessfully executed xhr request");
        console.log("calbbackData: " + JSON.stringify(callbackData));
        console.log("data: " + JSON.stringify(data));
        console.log("Note: this is a default callback, please overwrite me");
    },

    defaultFailureCallback: function failureCallback(data, textStatus, xhr) {
        console.log("Xhr request failed!");
        console.log("textStatus: " + JSON.stringify(textStatus));
        console.log("xhr: " + JSON.stringify(xhr));
        console.log("data: " + JSON.stringify(data));
        console.log("Note: this is a default callback, please overwrite me")
    }
}