<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Записная книга</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
    <div style="margin-left: 24px; margin-top: 24px;">
        <form action="/" method="post">
            <div class="field">
                <div class="control">
                    <input class="input is-small" type="text" placeholder="Name" name="name" style="width: 200px;">
                </div>
            </div>
            <div class="field">
                <div class="control">
                    <input class="input is-large" type="text" placeholder="Keep" name="text" style="width: 400px;">
                </div>
            </div>
            <div class="buttons">
                <input type="submit" class="button is-primary" value="Send">
            </div>
        </form>
        <div class="buttons" style="position: relative; bottom: 40px; left: 78px;">
            <a href="/notes">
            <button class="button is-link">Notes list</button>
            </a>
        </div>
    </div>
</body>
</html>