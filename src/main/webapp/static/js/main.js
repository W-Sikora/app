document.addEventListener('DOMContentLoaded', () => {

    const numberTypeInputExcludes = ['-', '+', 'e'];

    document.querySelectorAll('input[type="number"]').forEach(numberTypeInput => {

        numberTypeInput.addEventListener('keydown', (e) => {

            if (numberTypeInputExcludes.includes(e.key)) {

                e.preventDefault();
            }
        });
    })

    const navbarDropdownTrigger = document.getElementById('navbarDropdownTrigger');

    if (navbarDropdownTrigger) {

        const navbarDropdown = document.getElementById('navbarDropdown');

        navbarDropdownTrigger.addEventListener('click', (event) => {

            event.stopPropagation();

            navbarDropdown.classList.toggle('is-active');
        });
    }

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
