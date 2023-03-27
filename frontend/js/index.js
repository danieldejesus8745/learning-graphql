const form = document.getElementById('form');

form.addEventListener('submit', e => {
    e.preventDefault();

    const carDTO = Object.create(null);
    carDTO.vehicle = e.target.vehicle.value.trim();
    carDTO.manufacturer = e.target.manufacturer.value.trim();

    addCar(carDTO);
});

function addCar(carDTO) {
    const query = createMutation(carDTO);

    const options = {
        'method': 'POST',
        'headers': { 'Content-Type': 'application/json' },
        'body': JSON.stringify({ query })
    }

    fetch (`http://localhost:8080/graphql`, options);
}

function createMutation(carDTO) {
    return `
        mutation {addCar(carDTO: {vehicle: "${carDTO.vehicle}", manufacturer: "${carDTO.manufacturer}"})}
    `;
}