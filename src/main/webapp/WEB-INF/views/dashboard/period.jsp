<div class="column">

    <div class="field is-grouped is-grouped-centered">
        <p class="control">
            <button class="button" type="button" id="periodLeft">
                <i class="fas fa-chevron-left"></i>
            </button>
        </p>

        <p class="control">
            <input class="input" type="month" id="period" value="${period}" lang="${cookie['language'].value}"/>
        </p>

        <p class="control">
            <button class="button" type="button" id="periodRight">
                <i class="fas fa-chevron-right"></i>
            </button>
        </p>
    </div>

    <form id="periodForm" class="is-hidden">
        <input class="input" type="month" name="period"/>
        <sec:csrfInput/>
    </form>

</div>
