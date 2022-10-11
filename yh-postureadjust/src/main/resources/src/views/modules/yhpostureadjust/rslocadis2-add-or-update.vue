<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="aircraftId">
      <el-input v-model="dataForm.aircraftId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="flightId">
      <el-input v-model="dataForm.flightId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="fixtureId">
      <el-input v-model="dataForm.fixtureId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax5">
      <el-input v-model="dataForm.locax5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay5">
      <el-input v-model="dataForm.locay5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locaz5">
      <el-input v-model="dataForm.locaz5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax6">
      <el-input v-model="dataForm.locax6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay6">
      <el-input v-model="dataForm.locay6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locaz6">
      <el-input v-model="dataForm.locaz6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax7">
      <el-input v-model="dataForm.locax7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay7">
      <el-input v-model="dataForm.locay7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locaz7">
      <el-input v-model="dataForm.locaz7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax8">
      <el-input v-model="dataForm.locax8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay8">
      <el-input v-model="dataForm.locay8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locaz8">
      <el-input v-model="dataForm.locaz8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          aircraftId: '',
          flightId: '',
          fixtureId: '',
          locax5: '',
          locay5: '',
          locaz5: '',
          locax6: '',
          locay6: '',
          locaz6: '',
          locax7: '',
          locay7: '',
          locaz7: '',
          locax8: '',
          locay8: '',
          locaz8: '',
          time: ''
        },
        dataRule: {
          aircraftId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          flightId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fixtureId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locaz5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locaz6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locaz7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locaz8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/yhpostureadjust/rslocadis2/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.rsLocadis2.aircraftId
                this.dataForm.flightId = data.rsLocadis2.flightId
                this.dataForm.fixtureId = data.rsLocadis2.fixtureId
                this.dataForm.locax5 = data.rsLocadis2.locax5
                this.dataForm.locay5 = data.rsLocadis2.locay5
                this.dataForm.locaz5 = data.rsLocadis2.locaz5
                this.dataForm.locax6 = data.rsLocadis2.locax6
                this.dataForm.locay6 = data.rsLocadis2.locay6
                this.dataForm.locaz6 = data.rsLocadis2.locaz6
                this.dataForm.locax7 = data.rsLocadis2.locax7
                this.dataForm.locay7 = data.rsLocadis2.locay7
                this.dataForm.locaz7 = data.rsLocadis2.locaz7
                this.dataForm.locax8 = data.rsLocadis2.locax8
                this.dataForm.locay8 = data.rsLocadis2.locay8
                this.dataForm.locaz8 = data.rsLocadis2.locaz8
                this.dataForm.time = data.rsLocadis2.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/yhpostureadjust/rslocadis2/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'locax5': this.dataForm.locax5,
                'locay5': this.dataForm.locay5,
                'locaz5': this.dataForm.locaz5,
                'locax6': this.dataForm.locax6,
                'locay6': this.dataForm.locay6,
                'locaz6': this.dataForm.locaz6,
                'locax7': this.dataForm.locax7,
                'locay7': this.dataForm.locay7,
                'locaz7': this.dataForm.locaz7,
                'locax8': this.dataForm.locax8,
                'locay8': this.dataForm.locay8,
                'locaz8': this.dataForm.locaz8,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
