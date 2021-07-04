const allURL = 'products/all';
const pictureURL = 'products/picture/';

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
            
            
            //I:Title
            
            let titleDiv = document.createElement('DIV');
            
            let title = document.createElement('H3');
            
            let titleParagraph = document.createElement('P');
            
            titleParagraph.appendChild(document.createTextNode(product.title));
            
            title.appendChild(titleParagraph);
            
            titleDiv.appendChild(title);
            
            //F:Title
            
            //I:Picture

            let pictureDiv = document.createElement('DIV');
            
            let picture = document.createElement('IMG');
            let src = baseURL + pictureURL + product.idProduct;
            picture.setAttribute('src', src);
            
            pictureDiv.appendChild(picture);
            
            //F:Picture
            
            //I:Description
            
            let descriptionDiv = document.createElement('DIV');
            
            let descriptionParagraph = document.createElement('P');
            descriptionParagraph.appendChild(document.createTextNode(product.description));
            
            descriptionDiv.appendChild(descriptionParagraph);
            
            //F:Description
            
            //Append all
            
            wrapperDiv.appendChild(titleDiv);
            wrapperDiv.appendChild(pictureDiv);
            wrapperDiv.appendChild(descriptionDiv);
            
            refProductsMenu.appendChild(wrapperDiv);

        });
    }

}