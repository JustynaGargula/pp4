const a  = 5;
const foo = () => {console.log("hello world!!")};

(() => {
    foo();
})();

const getProducts = () => {
    return fetch("/api/products")
        .then(response => response.json());
}

const addToCart = (productId) => {
    return fetch(`/api/add-to-cart/${productId}`, {
        method: "POST",
        body: JSON.stringify({})
    }).then(response => {
        return response.json();
    })
};

const createHtmlFromString = (template) => {
    const tmpElem = document.createElement('div');
    tmpElem.innerHTML = template.trim();                      //trim bo nie moze miec spacji
    return tmpElem.firstChild;
}
const createHtmlComponent = (product) => {
    const template = `
        <li class={"product"}>
            <h4>${product.name}</h4>
            <img />
            <span>${product.price}</span>
            <button
                class="product__add-to-cart"
                data-product-id="${product.id}"
            >
                Add to cart +
            </button>
        </li>`
    ;
    return createHtmlFromString(template);
}

const getCurrentOffer = () =>{
    return fetch("api/get-current-offer")
        .then(response => response.json());
}

const refreshOffer = async () => {
    console.log('I am going to refresh offer');
    const offer = await getCurrentOffer();
    const cart = document.querySelector('.cart');

    cart.querySelector('.total').textContent = `${offer.total} PLN`;
    cart.querySelector('.itemsCount').textContent = `${offer.itemsCount} items`;
}


const initializeAddToCartHandler = (htmlEl) => {
    const btn = htmlEl.querySelector('button.product__add-to-cart')
    btn.addEventListener('click', () => {
        addToCart(btn.getAttribute('data-product-id'))
            .then(refreshOffer)                                     //z nawiasami po refreshOffer podkreśla
    });
    return htmlEl;
};

(()=>{
    const productListEl = document.querySelector('#products-list');
    console.log('it works');

    getProducts()
        .then(products => {
            products
                .map(product => createHtmlComponent(product))
                .map(productComponent => initializeAddToCartHandler(productComponent))
                .forEach(el => productListEl.appendChild(el));
        });
})();
