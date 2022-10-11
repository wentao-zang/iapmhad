<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="x轴" prop="vel1">
      <el-input v-model="dataForm.vel1" placeholder="x轴"></el-input>
    </el-form-item>
    <el-form-item label="y轴" prop="vel2">
      <el-input v-model="dataForm.vel2" placeholder="y轴"></el-input>
    </el-form-item>
    <el-form-item label="工位切换轴" prop="vel3">
      <el-input v-model="dataForm.vel3" placeholder="工位切换轴"></el-input>
    </el-form-item>
    <el-form-item label="孔探轴" prop="vel4">
      <el-input v-model="dataForm.vel4" placeholder="孔探轴"></el-input>
    </el-form-item>
    <el-form-item label="" prop="x1">
      <el-input v-model="dataForm.x1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="x2">
      <el-input v-model="dataForm.x2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="x3">
      <el-input v-model="dataForm.x3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="x4">
      <el-input v-model="dataForm.x4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp1">
      <el-input v-model="dataForm.temp1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp2">
      <el-input v-model="dataForm.temp2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp3">
      <el-input v-model="dataForm.temp3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="temp4">
      <el-input v-model="dataForm.temp4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power1">
      <el-input v-model="dataForm.power1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power2">
      <el-input v-model="dataForm.power2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power3">
      <el-input v-model="dataForm.power3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="power4">
      <el-input v-model="dataForm.power4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current1">
      <el-input v-model="dataForm.current1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current2">
      <el-input v-model="dataForm.current2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current3">
      <el-input v-model="dataForm.current3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="current4">
      <el-input v-model="dataForm.current4" placeholder=""></el-input>
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
          vel1: '',
          vel2: '',
          vel3: '',
          vel4: '',
          x1: '',
          x2: '',
          x3: '',
          x4: '',
          temp1: '',
          temp2: '',
          temp3: '',
          temp4: '',
          power1: '',
          power2: '',
          power3: '',
          power4: '',
          current1: '',
          current2: '',
          current3: '',
          current4: '',
          time: ''
        },
        dataRule: {
          vel1: [
            { required: true, message: 'x轴不能为空', trigger: 'blur' }
          ],
          vel2: [
            { required: true, message: 'y轴不能为空', trigger: 'blur' }
          ],
          vel3: [
            { required: true, message: '工位切换轴不能为空', trigger: 'blur' }
          ],
          vel4: [
            { required: true, message: '孔探轴不能为空', trigger: 'blur' }
          ],
          x1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          x2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          x3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          x4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          temp4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          power4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          current4: [
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
              url: this.$http.adornUrl(`/yhmachinedrilling/axisinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.vel1 = data.axisinfo.vel1
                this.dataForm.vel2 = data.axisinfo.vel2
                this.dataForm.vel3 = data.axisinfo.vel3
                this.dataForm.vel4 = data.axisinfo.vel4
                this.dataForm.x1 = data.axisinfo.x1
                this.dataForm.x2 = data.axisinfo.x2
                this.dataForm.x3 = data.axisinfo.x3
                this.dataForm.x4 = data.axisinfo.x4
                this.dataForm.temp1 = data.axisinfo.temp1
                this.dataForm.temp2 = data.axisinfo.temp2
                this.dataForm.temp3 = data.axisinfo.temp3
                this.dataForm.temp4 = data.axisinfo.temp4
                this.dataForm.power1 = data.axisinfo.power1
                this.dataForm.power2 = data.axisinfo.power2
                this.dataForm.power3 = data.axisinfo.power3
                this.dataForm.power4 = data.axisinfo.power4
                this.dataForm.current1 = data.axisinfo.current1
                this.dataForm.current2 = data.axisinfo.current2
                this.dataForm.current3 = data.axisinfo.current3
                this.dataForm.current4 = data.axisinfo.current4
                this.dataForm.time = data.axisinfo.time
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
              url: this.$http.adornUrl(`/yhmachinedrilling/axisinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'vel1': this.dataForm.vel1,
                'vel2': this.dataForm.vel2,
                'vel3': this.dataForm.vel3,
                'vel4': this.dataForm.vel4,
                'x1': this.dataForm.x1,
                'x2': this.dataForm.x2,
                'x3': this.dataForm.x3,
                'x4': this.dataForm.x4,
                'temp1': this.dataForm.temp1,
                'temp2': this.dataForm.temp2,
                'temp3': this.dataForm.temp3,
                'temp4': this.dataForm.temp4,
                'power1': this.dataForm.power1,
                'power2': this.dataForm.power2,
                'power3': this.dataForm.power3,
                'power4': this.dataForm.power4,
                'current1': this.dataForm.current1,
                'current2': this.dataForm.current2,
                'current3': this.dataForm.current3,
                'current4': this.dataForm.current4,
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
