<template>
    <div id="app">
        <div v-for="(card, key) in cards" v-bind:key="key">
            <div style="display: flex; flex-direction: row">
                <div
                    style="
                        display: flex;
                        flex-direction: column;
                        margin: 5%;
                        paddin: 5%;
                        background-color: rosybrown;
                        /* width: 50%; */
                    "
                >
                    <div class="field">
                        <h1>Фамилия:</h1>
                        <InputText
                            style="margin: 1%"
                            type="text"
                            v-model="card.lastName"
                            placeholder="Фамилия"
                            v-on:change="isEdit = card.id"
                        />
                    </div>
                    <div class="field">
                        <h1>Имя:</h1>
                        <InputText
                            style="margin: 1%"
                            type="text"
                            v-model="card.firstName"
                            placeholder="Имя"
                            v-on:change="isEdit = card.id"
                        />
                    </div>
                    <div class="field">
                        <h1>Отчество:</h1>
                        <InputText
                            style="margin: 1%"
                            type="text"
                            v-model="card.patronymic"
                            placeholder="Отчество"
                            v-on:change="isEdit = card.id"
                        />
                    </div>
                    <div class="field">
                        <h1>Заработная плата:</h1>
                        <InputText
                            style="margin: 1%"
                            type="text"
                            v-model="card.salary"
                            placeholder="Заработная плата"
                            v-on:change="isEdit = card.id"
                        />
                    </div>
                    <div class="field">
                        <h1>Выплачено: {{ card.money }}</h1>
                    </div>
                    <div class="field">
                        <h1>Выплата: {{ card.lastEnroll }}</h1>
                    </div>
                    <Slider
                        v-model="card.salary"
                        :max="99999"
                        v-on:change="isEdit = card.id"
                        style="margin: 3%"
                    />
                    <Button
                        v-if="isEdit === card.id"
                        style="margin: 3%"
                        label="Сохранить"
                        class="p-button-success"
                        v-on:click="saveCard(card)"
                    />
                    <Button
                        style="margin: 3%"
                        label="Удалить"
                        class="p-button-danger"
                        v-on:click="removeCard(card)"
                    />
                </div>
            </div>
        </div>
        <Button style="margin: 3%" label="Добавить" v-on:click="addCard" />
        <Dialog :visible="errorMessage != null" closable="false">
            {{ errorMessage }}
            <Button
                label="close"
                icon="pi pi-times"
                @click="errorMessage = null"
                class="p-button-text"
            />
        </Dialog>
    </div>
</template>

<script>
import InputText from "primevue/inputtext";
import Button from "primevue/button";
import Slider from "primevue/slider";
import Dialog from "primevue/dialog";
export default {
    name: "App",
    mounted() {
        const axios = require("axios");
        axios
            .get("http://localhost:8090/employee")
            .then((response) => (this.cards = response.data))
            .catch((error) => (this.errorMessage = error));
    },
    methods: {
        removeCard(removingCard) {
            console.log(removingCard);
            this.cards = this.cards.filter((card) => card !== removingCard);
            const axios = require("axios");
            axios
                .delete(
                    `http://localhost:8090/employee/remove/${removingCard.id}`
                )
                .catch((error) => (this.errorMessage = error));
        },

        saveCard(card) {
            console.log(card);
            const axios = require("axios");
            axios
                .post("http://localhost:8090/employee/add", {
                    id: card.id,
                    lastName: card.lastName,
                    firstName: card.firstName,
                    patrinymic: card.patrinymic,
                    lastEnroll: card.lastEnroll,
                    salary: card.salary,
                })
                // .catch((error) => (this.errorMessage = error.message))
                .catch((error) => console.log(error));

            this.isEdit = null;
        },

        addCard() {
            const date = new Date().toISOString().split('T')[0];
            // const date = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + (d.getDay() + 1);
            console.log(date)
            this.cards.push({
                id: Math.floor(Math.random() * 100000),
                firstName: "",
                lastName: "",
                patrinymic: "",
                lastEnroll: date,
                money: 0,
                salary: 0,
            });
        },
    },

    data() {
        return {
            cards: [],
            isEdit: null,
            errorMessage: null,
        };
    },

    сomponents: {
        InputText,
        Button,
        Slider,
        Dialog,
    },
};
</script>

<style>
#app {
    display: flex;
    flex-direction: column;
    justify-content: center;
}
h1 {
    margin-right: 3%;
}
.field {
    padding: 1%;
    display: flex;
    flex-direction: row;
    align-items: center;
    width: 50%;
}
</style>
