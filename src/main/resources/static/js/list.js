$container= document.querySelector(".container");
let database = document.querySelector("#list").innerHTML;
database = JSON.parse(database);

window.onload=
function getFGs(bj, dataToRetrieve){

    let template = '';

    for (let i = 0; i < database.length; i++) {
        let name = database[i].name;
        let firm = database[i].firm;
        let price = database[i].price;
        let amount = database[i].amount;
        let w = database[i].w;
        let minimum_batch = database[i].minimum_batch;
        template +=
            ' <div class="datalist">'+ "Name: "+
            name + "<br> "
            + "Firm: "+
             firm + "<br> "
            + "Price: "+
             price + "<br> "
            + "Amount: "+
             amount + " <br>"
            + "Warehouse: "+
             w+ "<br> "
            + "Minimum Batch: "+
             minimum_batch+ " <br>"+

            '</div>';


    }
    function getPropertyValue(obj, dataToRetrieve) {
        return dataToRetrieve
            .split('.')
            .reduce(function (o, k) {
                return o && o[k];
            }, obj)
    }

    $container.innerHTML = template;

}
