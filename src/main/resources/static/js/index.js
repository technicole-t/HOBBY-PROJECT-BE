const BASE_URL = "http://localhost:8090";

function postTrip() {
  const userTripInput = document.getElementById("user-input-trip-name");
  axios
    .post(BASE_URL + "/createTrip", {
      tripName: userTripInput.value,
    })
    .then((res) => res.data)
    .catch((err) => console.log(err));
}

document.getElementById("readAllTrips").addEventListener("click", function () {
  axios
    .get(BASE_URL + "/getTrips")
    .then((res) => {
      tripOutput.innerHTML = "";
      res.data.forEach((el) => {
        console.log(el);
        const newTrip = trip(
          "div",
          `${el.name}`,
          tripOutput,
          "card text-white bg-primary mb-3"
        );
        newTrip.addEventListener("click", function () {
          window.location = "./plan.html?trip=" + el.id;
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
