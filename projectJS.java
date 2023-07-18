//Emily Smith
//WEB 115-003
//Final Project
//July 13, 2023

function generateMealPlan() {
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;
  const goal = document.getElementById('goal').value;

  if (!validateEmail(email)) {
    alert('Please enter a valid email address.');
    return;
  }

  const meals = [
    { day: 'Monday', breakfast: '', snack1: '', lunch: '', snack2: '', dinner: '' },
    { day: 'Tuesday', breakfast: '', snack1: '', lunch: '', snack2: '', dinner: '' },
    { day: 'Wednesday', breakfast: '', snack1: '', lunch: '', snack2: '', dinner: '' },
    { day: 'Thursday', breakfast: '', snack1: '', lunch: '', snack2: '', dinner: '' },
    { day: 'Friday', breakfast: '', snack1: '', lunch: '', snack2: '', dinner: '' },
    { day: 'Saturday', breakfast: '', snack1: '', lunch: '', snack2: '', dinner: '' },
    { day: 'Sunday', breakfast: '', snack1: '', lunch: '', snack2: '', dinner: '' }
  ];

  const tableRows = document.querySelectorAll('#mealPlanForm table tr:not(:first-child)');
  tableRows.forEach((row, index) => {
    const day = row.cells[0].textContent;
    meals[index].breakfast = row.cells[1].querySelector('input').value;
    meals[index].snack1 = row.cells[2].querySelector('input').value;
    meals[index].lunch = row.cells[3].querySelector('input').value;
    meals[index].snack2 = row.cells[4].querySelector('input').value;
    meals[index].dinner = row.cells[5].querySelector('input').value;
  });

  const mealPlanPage = `
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Meal Plan</title>
      <style>
        body {
          font-family: monospace;
        }
      </style>
    </head>
    <body>
      <h1>Meal Plan for ${name}</h1>
      <h3>Email: ${email}</h3>
      <h3>Goal for the week:</h3>
      <p>${goal}</p>
      <h3>Meals:</h3>
      <table>
        <tr>
          <th>Day</th>
          <th>Breakfast</th>
          <th>Snack 1</th>
          <th>Lunch</th>
          <th>Snack 2</th>
          <th>Dinner</th>
        </tr>
        ${meals
          .map(
            meal => `
            <tr>
              <td>${meal.day}</td>
              <td>${meal.breakfast}</td>
              <td>${meal.snack1}</td>
              <td>${meal.lunch}</td>
              <td>${meal.snack2}</td>
              <td>${meal.dinner}</td>
            </tr>
          `
          )
          .join('')}
      </table>
      <script>
        window.print();
      </script>
    </body>
    </html>
  `;

  const newWindow = window.open('', '_blank');
  newWindow.document.write(mealPlanPage);
  newWindow.document.close();
}

function validateEmail(email) {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
}

