const pageObj = require("../pageobjects/herokuPage.js")
const expectChai = require('chai').expect();

describe('Heroku App /', async() => {

    it('Test Checkboxes', async () => {
        browser.getUrl("checkboxes")
        await pageObj.ClickCheckbox("checkbox 1")
        //expect(await pageObj.CheckBoxes().filter(box => box.getValue().trim() == "checkbox 1")).toBeSelected()
        browser.pause(10000);
    });



});


