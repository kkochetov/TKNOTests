@objects
    header           div.top-line
    button-*         div.top-line li.elem
    lng              div#langs

= Main section =
    @on fullhd
        header:
            inside viewport 0px top

        @forEach [ button-* ] as btn
            ${btn}:
                inside header

        lng:
            inside header