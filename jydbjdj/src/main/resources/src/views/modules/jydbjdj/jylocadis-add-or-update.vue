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
    <el-form-item label="" prop="locax1">
      <el-input v-model="dataForm.locax1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay1">
      <el-input v-model="dataForm.locay1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locaz1">
      <el-input v-model="dataForm.locaz1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax2">
      <el-input v-model="dataForm.locax2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay2">
      <el-input v-model="dataForm.locay2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locaz2">
      <el-input v-model="dataForm.locaz2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax3">
      <el-input v-model="dataForm.locax3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay3">
      <el-input v-model="dataForm.locay3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locaz3">
      <el-input v-model="dataForm.locaz3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locax4">
      <el-input v-model="dataForm.locax4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locay4">
      <el-input v-model="dataForm.locay4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locaz4">
      <el-input v-model="dataForm.locaz4" placeholder=""></el-input>
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
          locax1: '',
          locay1: '',
          locaz1: '',
          locax2: '',
          locay2: '',
          locaz2: '',
          locax3: '',
          locay3: '',
          locaz3: '',
          locax4: '',
          locay4: '',
          locaz4: '',
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
          locax1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locaz1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locaz2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locaz3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locax4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locay4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locaz4: [
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
              url: this.$http.adornUrl(`/jydbjdj/jylocadis/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.jyLocadis.aircraftId
                this.dataForm.flightId = data.jyLocadis.flightId
                this.dataForm.fixtureId = data.jyLocadis.fixtureId
                this.dataForm.locax1 = data.jyLocadis.locax1
                this.dataForm.locay1 = data.jyLocadis.locay1
                this.dataForm.locaz1 = data.jyLocadis.locaz1
                this.dataForm.locax2 = data.jyLocadis.locax2
                this.dataForm.locay2 = data.jyLocadis.locay2
                this.dataForm.locaz2 = data.jyLocadis.locaz2
                this.dataForm.locax3 = data.jyLocadis.locax3
                this.dataForm.locay3 = data.jyLocadis.locay3
                this.dataForm.locaz3 = data.jyLocadis.locaz3
                this.dataForm.locax4 = data.jyLocadis.locax4
                this.dataForm.locay4 = data.jyLocadis.locay4
                this.dataForm.locaz4 = data.jyLocadis.locaz4
                this.dataForm.time = data.jyLocadis.time
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
              url: this.$http.adornUrl(`/jydbjdj/jylocadis/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'locax1': this.dataForm.locax1,
                'locay1': this.dataForm.locay1,
                'locaz1': this.dataForm.locaz1,
                'locax2': this.dataForm.locax2,
                'locay2': this.dataForm.locay2,
                'locaz2': this.dataForm.locaz2,
                'locax3': this.dataForm.locax3,
                'locay3': this.dataForm.locay3,
                'locaz3': this.dataForm.locaz3,
                'locax4': this.dataForm.locax4,
                'locay4': this.dataForm.locay4,
                'locaz4': this.dataForm.locaz4,
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
