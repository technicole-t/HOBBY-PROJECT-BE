const BASE_URL = "http://localhost:8090";

function seeJourneyValues() {
  const journeyID = new URLSearchParams(window.location.search).get("journey");
  axios.get(BASE_URL + "/getJourneyById/" + journeyID).then((res) => {
    document.getElementById("update-departure-airport").value =
      res.data.departureAirport;
    document.getElementById("update-destination-airport").value =
      res.data.destinationAirport;
    document.getElementById("update-mode-of-travel").value =
      res.data.modeOfTravel;
    document.getElementById("update-date-of-travel").value = res.data.date;
  });
}

function updateAJourney() {
  const journeyId = new URLSearchParams(window.location.search).get("journey");
  axios
    .put(BASE_URL + "/updateJourney/" + journeyId, {
      departureAirport: document.getElementById("update-departure-airport")
        .value,
      destinationAirport: document.getElementById("update-destination-airport")
        .value,
      modeOfTravel: document.getElementById("update-mode-of-travel").value,
      date: document.getElementById("update-date-of-travel").value,
    })
    .then((res) => res.data)
    .then(alert("Journey Sucessfully Updated!!"))
    .catch((err) => console.log(err));
}

function deleteData(tripID) {
  const tripId = new URLSearchParams(window.location.search).get("journey");
  return fetch(BASE_URL + "/deleteAJourney/" + tripId, {
    method: "delete",
  })
    .then((response) => response.json())
    .then(alert("Journey Sucessfully deleted"))
    .catch((err) => console.log(err));
}

function trip(elementType, text, appendTo, className) {
  const element = document.createElement(elementType);
  element.innerText = text;
  appendTo.appendChild(element);
  element.className = className;
  return element;
}
