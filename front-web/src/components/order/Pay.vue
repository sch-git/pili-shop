<template>
<main>
  <div v-html="formData">
    {{formData}}
  </div>
</main>
</template>

<script>
export default {
  name: 'Pay',
  data () {
    return {

    }
  },
  created () {
  },
  mounted () {
    this.$nextTick(() => {
      document.forms[0].submit()
    })
  },
  computed: {
    formData () {
      return this.$store.state.payForm
    }
  }
}
</script>

<style scoped>

</style>
