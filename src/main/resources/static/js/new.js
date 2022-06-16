let a = 1;
let $nameInput1= document.querySelector("#floatingInput");
let $nameInput2= document.querySelector("#floatingInput2");
let $nameInput3= document.querySelector("#floatingInput3");
let $nameInput4= document.querySelector("#floatingInput4");
let $nameInput5= document.querySelector("#floatingInput5");
let $nameInput6= document.querySelector("#floatingInput6");
let $nameInput7= document.querySelector("#floatingPassword");
let $buttonInput = document.querySelector(".btn-primary");
const url = 'http://localhost:8080/create/add'



$buttonInput.addEventListener('click', async function () {
    const data = {
        name: $nameInput1.value,
        firm: $nameInput2.value,
        price: $nameInput3.value,
        amount: $nameInput4.value,
        w: $nameInput5.value,
        date: 0,
        minimum_batch: $nameInput7.value,
    };
    try {

        const response = await fetch(url, {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }

        });

    } catch (error) {
        console.error('Err:', error);

    }
})