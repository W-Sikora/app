document.addEventListener('DOMContentLoaded', () => {

    // const activeDropdownClass = 'is-active';
    //
    // window.addEventListener('click', () => {
    //
    //     document.querySelectorAll('.dropdown').forEach(dropdown => {
    //
    //         if (dropdown.classList.contains(activeDropdownClass)) {
    //
    //             dropdown.classList.remove(activeDropdownClass);
    //         }
    //     })
    // });

    const numberTypeInputExcludes = ['-', '+', 'e'];

    document.querySelectorAll('input[type="number"]').forEach(numberTypeInput => {

        numberTypeInput.addEventListener('keydown', (e) => {

            if (numberTypeInputExcludes.includes(e.key)) {

                e.preventDefault();
            }
        });
    })

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

    document.querySelectorAll('.change-locale').forEach(el =>

        el.addEventListener('click', () => {

            changeLocale(el.dataset.code)
        })
    );

    function changeLocale(code) {

        const request = new XMLHttpRequest();

        request.open('POST', '/locale', true);

        request.onload = () => {

            location.reload();
        }

        request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

        request.send(JSON.stringify({'code': code}));
    }

});
