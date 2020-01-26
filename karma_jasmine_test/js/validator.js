(function( $ ) {
 
    const invalidClass = 'invalid';

    $.fn.validator = function(regex) {
         this.each(function() {
            var element = $( this );
            if(regex.test(element.text())) {
                element.addClass(invalidClass)
            } else {
                element.removeClass(invalidClass)
            }
        });
         return this;
     };
 
}( jQuery ));