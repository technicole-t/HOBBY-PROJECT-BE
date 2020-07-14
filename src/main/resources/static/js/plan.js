const BASE_URL = "http://localhost:8090";

function createJourney() {
  const tripID = new URLSearchParams(window.location.search).get("trip");

  axios
    .post(BASE_URL + "/createJourney", {
      departureAirport: document.getElementById("departure-airport").value,
      destinationAirport: document.getElementById("destination-airport").value,
      modeOfTravel: document.getElementById("mode-of-travel").value,
      date: document.getElementById("date-of-travel").value,
      trip: {
        tripId: tripID,
      },
    })
    .then((res) => res.data)
    .catch((err) => console.log(err));
}

document
  .getElementById("getAllJourneys")
  .addEventListener("click", function () {
    axios
      .get(BASE_URL + "/getAllJourneys")
      .then((res) => {
        const journeyOutput = document.getElementById("journeyOutput");
        journeyOutput.innerHTML = "";
        res.data.forEach((element) => {
          const newJourney = trip(
            "p",
            `From: ${element.departureAirport} To: ${element.destinationAirport} By: ${element.modeOfTravel} On: ${element.date}`,
            journeyOutput,
            "table border border"
          );
          newJourney.addEventListener("click", () => {
            window.location = "./update.html?journey=" + element.id;
          });
        });
      })
      .catch((err) => console.log(err));
  });

function trip(elementType, text, appendTo, className) {
  const element = document.createElement(elementType);
  element.innerText = text;
  appendTo.appendChild(element);
  element.className = className;
  return element;
}
