<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Записи</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
    <div style="margin-left: 24px; margin-top: 24px;">
        <form method="get" style="padding-bottom: 20px; display: flex">
            <div class="control">
                <input class="input" type="text" placeholder="Search..." name="search" style="width: 200px; height: 40px;">
            </div>
            <div class="buttons">
                <input class="button is-primary" type="submit" style="margin-left: 10px; height: 40px" value="Search">
            </div>

        </form>
        <#if notes?has_content>
            <#list notes as note>
                <div class="content is-small" style="margin-bottom: 7px;" >
                    <h1>${note.name}</h1>
                    <p>${note.text}</p>
                </div>
                <div style="height: 1px; width: 200px; background-color: #dcdcdc; opacity: .5; margin-bottom: 7px"></div>
            </#list>
        <#else>
            Note list is empty
        </#if>
        <#if pages?? && pages != 0>
        <nav class="pagination" role="navigation" aria-label="pagination" style="padding-top: 20px">
                <ul class="pagination-list">
            <#list 1..pages as page>
                    <li>
                        <a href="/notes?search=${search}&page=${page}" class="pagination-link" aria-label="Page 1" aria-current="page">${page}</a>
                    </li>
            </#list>
                </ul>
        </nav>
        </#if>
        <p><a href="/">
            <button class="button is-light">Start page</button>
        </a></p>
    </div>
</body>
</html>