document.addEventListener('DOMContentLoaded', () => {

    const activeClass = 'is-active';
    const numberInputExcludes = ['-', '+', 'e'];

    document.querySelectorAll('input[type="number"]').forEach(numberInput => {

        numberInput.addEventListener('keydown', (e) => {

            if (numberInputExcludes.includes(e.key)) {

                e.preventDefault();
            }
        });
    });

    const paginators = document.querySelectorAll('.js-pagination');

    if (paginators) {

        paginators.forEach(paginator => {

            const currentPage = paginator.dataset.currentPage;
            const lastPage = paginator.dataset.lastPage - 1;
            const previousPageButton = paginator.querySelector('.js-previous-page-button');
            const nextPageButton = paginator.querySelector('.js-next-page-button');
            const form = paginator.querySelector('.js-pagination-form');
            const input = form.querySelector('input.js-parameter-name');

            previousPageButton.addEventListener('click', () => {

                if (currentPage > 0) {

                    input.value = +currentPage - 1;
                    form.submit();
                }
            });

            nextPageButton.addEventListener('click', () => {

                if (currentPage < lastPage) {

                    input.value = +currentPage + 1;
                    form.submit();
                }
            });
        });
    }

    const logoutButton = document.getElementById('logoutButton');

    if (logoutButton) {

        logoutButton.addEventListener('click', () => document.getElementById('logout').submit())
    }

    const keywordFilter = document.querySelector('.js-keyword-filter');

    if (keywordFilter) {

        const params = new URLSearchParams(window.location.search);

        for (const param of params.keys()) {

            if (param) {

                keywordFilter.querySelector('input').value = params.get(param);
            }
        }

        keywordFilter.querySelector('.js-clear')
            .addEventListener('click', () => {

                keywordFilter.querySelector('input').value = '';

                keywordFilter.submit();
            });
    }

    const categoryFilter = document.querySelector('.js-category-filter');

    if (categoryFilter) {

        const params = new URLSearchParams(window.location.search);

        for (const param of params.keys()) {

            if (param) {

                categoryFilter.querySelector('select[name=' + param + ']').value = params.get(param);
            }
        }

        categoryFilter.querySelector('.js-clear-category')
            .addEventListener('click', () => {

                [...categoryFilter.getElementsByTagName('select')].forEach(select => {

                    select.value = '';
                });

                categoryFilter.submit();

            });
    }

    const deleteButtons = document.querySelectorAll('.js-delete-button');

    if (deleteButtons) {

        function openModal(element) {

            element.classList.add(activeClass);
        }

        function closeModal(element) {

            element.classList.remove(activeClass);
        }

        deleteButtons.forEach(deleteButton => {

            deleteButton.addEventListener('click', () => {

                const deleteUrl = deleteButton.dataset.delete;

                const modal = document.getElementById('modal');

                openModal(modal);

                modal.querySelector('.js-cancel-button')
                    .addEventListener('click', () => closeModal(modal));

                modal.querySelector('.js-final-delete').action = deleteUrl;
            });
        });
    }

    const navbarUserDropdownTrigger = document.getElementById('navbarUserDropdownTrigger');

    if (navbarUserDropdownTrigger) {

        const navbarUserDropdown = document.getElementById('navbarUserDropdown');

        navbarUserDropdownTrigger.addEventListener('click', () => {

            navbarUserDropdown.classList.toggle('is-active');

            const copyUuidButton = document.getElementById('copyUuid');

            if (copyUuidButton) {

                const uuidInput = document.getElementById('uuidInput');

                copyUuidButton.addEventListener('click', (event) => {

                    event.stopPropagation();

                    uuidInput.select();
                    uuidInput.setSelectionRange(0, 99999);

                    navigator.clipboard.writeText(uuidInput.value);
                });
            }
        });
    }

    const navbarLocaleDropdownTrigger = document.getElementById('navbarLocaleDropdownTrigger');

    if (navbarLocaleDropdownTrigger) {

        const navbarLocaleDropdown = document.getElementById('navbarLocaleDropdown');

        navbarLocaleDropdownTrigger.addEventListener('click', () => {

            navbarLocaleDropdown.classList.toggle('is-active');
        });
    }

    const changeLocaleElements = document.querySelectorAll('.change-locale');

    if (changeLocaleElements) {

        function changeLocale(code) {

            const locale = document.getElementById('locale');

            locale.querySelector('input[name=code]').value = code;

            locale.submit();

            location.reload();
        }

        changeLocaleElements.forEach(el =>

            el.addEventListener('click', () => changeLocale(el.dataset.code))
        );
    }


    const colorsArray = [
        'rgba(0, 135, 108, 0.5)',
        'rgba(239, 86, 117, 0.5)',
        'rgba(153, 177, 142, 0.5)',
        'rgba(229, 115, 115, 0.5)',
        'rgba(179, 157, 219, 0.5)',
        'rgba(250, 202, 40, 0.5)',
        'rgba(144, 202, 249, 0.5)',
        'rgba(55, 76, 128, 0.5)',
        'rgba(38, 166, 154, 0.5)',
        'rgba(120, 144, 156, 0.5)',
        'rgba(174, 213, 129, 0.5)',
        'rgba(255, 138, 101, 0.5)',
        'rgba(121, 85, 72, 0.5)',
        'rgba(102, 187, 106, 0.5)',
        'rgba(212, 61, 81, 0.5)',
        'rgba(255, 118, 74, 0.5)',
        'rgba(122, 81, 149, 0.5)',
        'rgba(255, 166, 0, 0.5)',
        'rgba(119, 163, 125, 0.5)',
        'rgba(216, 181, 145, 0.5)',
        'rgba(216, 129, 96, 0.5)',
        'rgba(211, 47, 47, 0.5)',
        'rgba(182, 191, 163, 0.5)',
        'rgba(216, 156, 117, 0.5)',
        'rgba(215, 98, 84, 0.5)',
        'rgba(0, 63, 92, 0.5)',
        'rgba(220, 231, 117, 0.5)',
        'rgba(244, 67, 54, 0.5)',
        'rgba(79, 149, 114, 0.5)',
        'rgba(188, 80, 144, 0.5)',
        'rgba(0, 137, 123, 0.5)'
    ];

    const doughnutChartId = document.getElementById('doughnutChart');

    if (doughnutChartId) {

        const labels = ['OKaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'WARNING', 'CRITICAL', 'UNKNOWN', 'OK1', 'WARNING1', 'CRITICAL1', 'UNKNOWN1'];
        const data = [12, 19, 3, 5, 12, 19, 3, 5];

        new Chart(doughnutChartId, {
            type: 'doughnut',
            data: {
                labels: labels,
                datasets: [{
                    data: data,
                    backgroundColor: colorsArray
                }]
            },
            options: {
                legend: {
                    display: true,
                    position: 'bottom',
                    align: 'start',
                    labels: {
                        padding: 15
                    }
                }
            }
        });
    }

    const horizontalBarChartId = document.getElementById('horizontalBarChart');

    if (horizontalBarChartId) {

        const horizontalBarChartData = {
            labels: [
                "ME",
                "SE",
                "a",
                "b",
                "ME",
                "SE",
                "a",
                "b"
            ],
            datasets: [{
                label: "Test",
                data: [109, 75, 2, 34, 109, 75, 2, 34],
                backgroundColor: colorsArray,
                maxBarThickness: 35
            }]
        };

        new Chart(horizontalBarChartId, {
            type: 'horizontalBar',
            data: horizontalBarChartData,
            options: {
                scales: {
                    xAxes: [{
                        ticks: {
                            min: 0,
                            max: 100
                        }
                    }]
                },

                legend: {
                    display: false
                },
                tooltips: {
                    callbacks: {
                        label: function (tooltipItem) {
                            console.log(tooltipItem)
                            return tooltipItem.yLabel;
                        }
                    }
                }
            }

        });
    }
});
