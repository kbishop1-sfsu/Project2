var myHeaders = new Headers();
myHeaders.append("Authorization", "Bearer Txd3eOxcK2D3MWKr6-a3Z0UlYBjytGSIkTuKiibJ09r2MVABDmqypZ0IaNB_EvlXxkWJHLm4GKoXviFJXYtt2pEhbOE5-xKraKVjFQaGu9kHPlZCtNQakXZJrj76YnYx");

var requestOptions = {
  method: 'GET',
  headers: myHeaders,
  redirect: 'follow'
};

fetch("https://api.yelp.com/v3/businesses/search?location=Seattle", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));