@objects
    container           div.content__inner
    content             div.content__404
    label404            div.content__404 h1
    img                 div.content__404 img
    link                div.content__404 a

= Main section =
    @on fullhd
        container:
            inside viewport

        content:
            inside container

        label404:
            inside container

        img:
            inside container
            below label404 >=0px

        link:
            inside container
            below img >=0px
