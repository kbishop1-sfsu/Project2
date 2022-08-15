var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };
  
  fetch("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=47.608013,-122.335167&radius=500&type=restaurant&key=AIzaSyDAlAcb3c_9J9eVq2HApD_U1v9tqmg8WTY", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));