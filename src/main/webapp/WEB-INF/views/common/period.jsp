<div class="column">

    <div class="field is-grouped is-grouped-centered">
        <p class="control">
            <button class="button" type="button" id="periodLeft">
                <i class="fas fa-chevron-left"></i>
            </button>
        </p>

        <p class="control">
            <input class="input" type="date" name="period" id="period" value="${period}"/>
        </p>

        <p class="control">
            <button class="button" type="button" id="periodRight">
                <i class="fas fa-chevron-right"></i>
            </button>
        </p>
    </div>

</div>

<script>

    function convertDateToString(date) {

        const month = date.getMonth() + 1;

        if (month < 10) {

            return '' + date.getFullYear() + '-0' + date.getMonth();
        }

        return '' + date.getFullYear() + '-' + date.getMonth();
    }

    document.addEventListener('DOMContentLoaded', function () {

        const periodLeft = document.querySelector('#periodLeft');
        const periodRight = document.querySelector('#periodRight');
        const period = document.querySelector('#period');
        const periodDate = new Date(period.value);

        periodLeft.addEventListener('click', () => {

            const newDate = new Date(periodDate.setMonth(periodDate.getMonth() - 1));
            console.log(newDate + '\n' + convertDateToString(newDate))
            period.value = convertDateToString(newDate);
        });

        periodRight.addEventListener('click', () => {

            const newDate = new Date(periodDate.setMonth(periodDate.getMonth() + 1));
            console.log(newDate)
            period.value = convertDateToString(newDate);
        });

    });
</script>
