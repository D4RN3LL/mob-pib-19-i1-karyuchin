import Vue from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config';

Vue.config.productionTip = false

Vue.use(PrimeVue);
import "primevue/resources/themes/saga-blue/theme.css"; //theme
import "primevue/resources/primevue.min.css"; //core css
import "primeicons/primeicons.css"; //icons

import InputText from 'primevue/inputtext';
Vue.component('InputText', InputText);

import Button from 'primevue/button';
Vue.component('Button', Button);

import Slider from 'primevue/slider';
Vue.component('Slider', Slider);

import Dialog from 'primevue/dialog';
Vue.component('Dialog', Dialog);

new Vue({
  render: h => h(App),
}).$mount('#app')
