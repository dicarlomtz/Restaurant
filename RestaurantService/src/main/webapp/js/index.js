const allURL = 'products/all';
const pictureURL = 'products/picture/';

$(document).ready(init);

function init() {
    fetchProducts();
}

function fetchProducts() {
    obtainData(allURL, 'GET', fetchProductsCallback);
}

function fetchProductsCallback(data) {

    let refProductsMenu = document.getElementById('menu');

    if (refProductsMenu) {
        let products = data['products'];

        products.forEach((product) => {
            let wrapperDiv = document.createElement('DIV');

            wrapperDiv.setAttribute("class", "col");
            wrapperDiv.setAttribute("style", "width: 15rem;");
            wrapperDiv.classList.toggle("card");
            wrapperDiv.classList.toggle("m-3");
            wrapperDiv.classList.toggle("p-3");

            //I:Picture

            let pictureDiv = document.createElement('DIV');

            let picture = document.createElement('IMG');
            let src = baseURL + pictureURL + product.idProduct;
            picture.setAttribute('src', src);
            picture.setAttribute("class", "card-img-top");
            picture.style.height = "200px";
            
            pictureDiv.appendChild(picture);
            wrapperDiv.appendChild(pictureDiv);

            //F:Picture

            //I:Title

            let titleDiv = document.createElement('DIV');
            titleDiv.setAttribute("class", "mt-2");
            let title = document.createElement('H5');
            title.setAttribute("class", "card-title");

            let titleParagraph = document.createElement('P');

            titleParagraph.appendChild(document.createTextNode(product.title));

            title.appendChild(titleParagraph);

            titleDiv.appendChild(title);
            wrapperDiv.appendChild(titleDiv);

            //F:Title   

            //I:Price

            let descriptionDiv = document.createElement('DIV');

            let descriptionParagraph = document.createElement('P');
            descriptionParagraph.appendChild(document.createTextNode("$" + product.price));
            descriptionParagraph.setAttribute("class", "card-text");

            descriptionDiv.appendChild(descriptionParagraph);
            wrapperDiv.appendChild(descriptionDiv);

            //F:Price

            //Append all
            
            refProductsMenu.appendChild(wrapperDiv);

        });
    }

}