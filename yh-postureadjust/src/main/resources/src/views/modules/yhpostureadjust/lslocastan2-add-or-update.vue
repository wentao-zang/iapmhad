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
    <el-form-item label="" prop="locasx5">
      <el-input v-model="dataForm.locasx5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy5">
      <el-input v-model="dataForm.locasy5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasz5">
      <el-input v-model="dataForm.locasz5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx6">
      <el-input v-model="dataForm.locasx6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy6">
      <el-input v-model="dataForm.locasy6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasz6">
      <el-input v-model="dataForm.locasz6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx7">
      <el-input v-model="dataForm.locasx7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy7">
      <el-input v-model="dataForm.locasy7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasz7">
      <el-input v-model="dataForm.locasz7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx8">
      <el-input v-model="dataForm.locasx8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy8">
      <el-input v-model="dataForm.locasy8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasz8">
      <el-input v-model="dataForm.locasz8" placeholder=""></el-input>
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
          locasx5: '',
          locasy5: '',
          locasz5: '',
          locasx6: '',
          locasy6: '',
          locasz6: '',
          locasx7: '',
          locasy7: '',
          locasz7: '',
          locasx8: '',
          locasy8: '',
          locasz8: '',
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
          locasx5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasz5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasz6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasz7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasz8: [
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
              url: this.$http.adornUrl(`/yhpostureadjust/lslocastan2/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.lsLocastan2.aircraftId
                this.dataForm.flightId = data.lsLocastan2.flightId
                this.dataForm.fixtureId = data.lsLocastan2.fixtureId
                this.dataForm.locasx5 = data.lsLocastan2.locasx5
                this.dataForm.locasy5 = data.lsLocastan2.locasy5
                this.dataForm.locasz5 = data.lsLocastan2.locasz5
                this.dataForm.locasx6 = data.lsLocastan2.locasx6
                this.dataForm.locasy6 = data.lsLocastan2.locasy6
                this.dataForm.locasz6 = data.lsLocastan2.locasz6
                this.dataForm.locasx7 = data.lsLocastan2.locasx7
                this.dataForm.locasy7 = data.lsLocastan2.locasy7
                this.dataForm.locasz7 = data.lsLocastan2.locasz7
                this.dataForm.locasx8 = data.lsLocastan2.locasx8
                this.dataForm.locasy8 = data.lsLocastan2.locasy8
                this.dataForm.locasz8 = data.lsLocastan2.locasz8
                this.dataForm.time = data.lsLocastan2.time
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
              url: this.$http.adornUrl(`/yhpostureadjust/lslocastan2/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'locasx5': this.dataForm.locasx5,
                'locasy5': this.dataForm.locasy5,
                'locasz5': this.dataForm.locasz5,
                'locasx6': this.dataForm.locasx6,
                'locasy6': this.dataForm.locasy6,
                'locasz6': this.dataForm.locasz6,
                'locasx7': this.dataForm.locasx7,
                'locasy7': this.dataForm.locasy7,
                'locasz7': this.dataForm.locasz7,
                'locasx8': this.dataForm.locasx8,
                'locasy8': this.dataForm.locasy8,
                'locasz8': this.dataForm.locasz8,
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
