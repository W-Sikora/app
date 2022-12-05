document.addEventListener('DOMContentLoaded', () => {

    const numberTypeInputExcludes = ['-', '+', 'e'];

    document.querySelectorAll('input[type="number"]').forEach(numberTypeInput => {

        numberTypeInput.addEventListener('keydown', (e) => {

            if (numberTypeInputExcludes.includes(e.key)) {

                e.preventDefault();
            }
        });
    })



});
