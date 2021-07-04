const baseURL = 'http://localhost:8080/RestaurantService/restaurant/';

function obtainData(url, methodType, callback) {
    fetch(baseURL + url, {
        method: methodType
    }).then(result => {
        if (result.status === 200) {
            return result.json();
        } else {
            console.error(`HTTP error: ${result.status}`);
        }
    }).then(
            callback
            ).catch(errCode => {
        console.error(errCode);
    });
}

function sendData(url, methodType, data, callback) {
    fetch(baseURL + url, {
        method: methodType,
        body: data
    }).then(result => {
        if (result.status === 200) {
            return result.json();
        } else {
            console.error(`HTTP error: ${result.status}`);
        }
    }).then(
            callback
            ).catch(errCode => {
        console.error(errCode);
    });
}