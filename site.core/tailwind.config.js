/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './resources/public/index.html',
    './resources/public/cljs-out/**/*.js',
  ],
  theme: {
    extend: {
      colors: {
        'dark-bg': '#121212', // Dark background
        'dark-bg-light': '#1E1E1E', // Slightly lighter background
        'light-text': '#E0E0E0', // Light text color
        'accent': '#FFD700', // Accent color (gold)
        'accent-dark': '#665E00', // Darker accent color
      },
    },
  },
  plugins: [],
}
