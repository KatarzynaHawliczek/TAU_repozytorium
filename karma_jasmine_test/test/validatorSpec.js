describe("validator", function () {
    
    beforeAll(function () {
        $('body').append(`
        <div id="name">66kasia66</div>
        <div id="age">18</div>
        <div id="any1" class="abc">0ab</div>
        <div id="any2" class="abc">?cd</div>
        `);
    });

    it("validation successful", function () {
        $('#name').validator(/^[A-Z][a-z]+/);
        expect($('#name').hasClass('invalid')).toBe(false);
    });

    it("validation unsuccessful", function () {
        $('#age').validator(/^\d+/);
        expect($('#age').hasClass('invalid')).toBe(true);
    });

    it("validation partially successful", function () {
        $('.abc').validator(/^\d[a-z]*/);
        expect($('#any1').hasClass('invalid')).toBe(true);
        expect($('#any2').hasClass('invalid')).toBe(false);
    })
});