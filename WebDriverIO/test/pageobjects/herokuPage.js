class herokuPage {
    get CheckBoxes(){
        return $$("#checkboxes input")
    }

    async ClickCheckbox(checkBoxToClick){
        var CheckBoxes = this.CheckBoxes
       console.log(CheckBoxes.filter(box => box.getText().trim() === checkBoxToClick && !box.isSelected()).map(box => box.click())
    }

}
module.exports = new herokuPage();